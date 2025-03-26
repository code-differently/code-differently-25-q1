import { Inject, Injectable } from '@nestjs/common';
import { program } from 'commander';
import readline from 'readline';
import { Loader } from '../loaders/loader.js';
import { Loaders } from '../loaders/loaders.module.js';
import { MediaCollection } from '../models/media_collection.js';
import { MediaItem } from '../models/media_item.js';
import { SearchCriteria } from '../models/search_criteria.js';
import { Scanner } from './scanner.js';

const read = readline.createInterface({
  input: process.stdin, //this acts as an input scanner
  output: process.stdout, //this works like a normal console.log combined with a user's input
});

enum MainCommand {
  EXIT = 1,
  SEARCH,
  UNKNOWN,
}

enum SearchCommand {
  RETURN = 1,
  TITLE,
  RELEASE_YEAR,
  CAST_NAME,
  UNKNOWN,
}

@Injectable()
export class MediaCollectionApp {
  constructor(@Inject(Loaders) private readonly loaders: Loader[]) {}

  async run(): Promise<void> {
    const loaderName = this.getLoaderFromCommandLine();
    const collection = await this.loadCollectionUsingLoader(loaderName);

    this.printMediaCollection(collection);

    const scanner = new Scanner(read);
    let command: MainCommand;
    while (
      (command = await this.promptForCommand(scanner)) !== MainCommand.EXIT
    ) {
      switch (command) {
        case MainCommand.SEARCH:
          await this.doSearch(scanner, collection);
          break;
        default:
          console.log('\nNot ready yet, coming soon!');
      }
    }
  }

  private async loadCollectionUsingLoader(loaderName: string | null) {
    const collection = new MediaCollection();
    if (loaderName) {
      const loader = this.loaders.filter(
        (l) => l.getLoaderName() === loaderName,
      );
      if (loader) {
        const items = await loader[0].loadData();
        items.forEach((item) => collection.addItem(item));
      }
    }
    return collection;
  }

  private printMediaCollection(collection: MediaCollection): void {
    const info = collection.getInfo();
    console.log();
    console.log('========================================');
    console.log('Number of items: ' + info.getItems().length);
    console.log('========================================');
    console.log();
  }

  private getLoaderFromCommandLine(): string | null {
    program.option('-l, --loader <type>');
    program.parse();

    const options = program.opts();
    return options.loader;
  }

  private async promptForCommand(scanner: Scanner): Promise<MainCommand> {
    let command: MainCommand = MainCommand.UNKNOWN;
    while (
      command === MainCommand.UNKNOWN ||
      MainCommand[command] === undefined
    ) {
      this.printMenu();
      const input = await scanner.prompt('command');
      try {
        command = parseInt(input.trim());
      } catch {
        console.log('Invalid command: ' + input);
      }
    }
    return command;
  }

  private printMenu(): void {
    console.log('\nEnter the number of the desired command:');
    console.log('1) << EXIT');
    console.log('2) SEARCH');
  }

  private async doSearch(
    scanner: Scanner,
    collection: MediaCollection,
  ): Promise<void> {
    const command = await this.promptForSearchCommand(scanner);
    if (command === SearchCommand.RETURN) {
      return;
    }
    const criteria = await this.getSearchCriteria(scanner, command);
    const results = collection.search(criteria);
    this.printSearchResults(results);
  }

  private async promptForSearchCommand(
    scanner: Scanner,
  ): Promise<SearchCommand> {
    let command: SearchCommand = SearchCommand.UNKNOWN;
    while (
      command === SearchCommand.UNKNOWN ||
      SearchCommand[command] === undefined
    ) {
      this.printSearchMenu();
      const input = await scanner.prompt('search');
      try {
        command = parseInt(input.trim());
      } catch {
        console.log('Invalid command: ' + input);
      }
    }
    return command;
  }

  private printSearchMenu(): void {
    console.log('\nEnter the number of the desired search criteria:');
    console.log('1) << RETURN');
    console.log('2) TITLE');
    console.log('3) AUTHOR');
    console.log('4) TYPE');
  }

  private async getSearchCriteria(
    scanner: Scanner,
    command: SearchCommand,
  ): Promise<SearchCriteria | undefined> {
    console.log();
    switch (command) {
      case SearchCommand.TITLE: {
        console.log('Enter the title to search for: ');
        const title = await scanner.prompt('title');
        return { title };
      }
      case SearchCommand.RELEASE_YEAR: {
        console.log('Enter the release year to search for: ');
        const releaseYear = await scanner.prompt('year');
        return { releaseYear: parseInt(releaseYear) };
      }
      case SearchCommand.CAST_NAME: {
        console.log('Enter the cast name to search for: ');
        const creditName = await scanner.prompt('type');
        return { creditName };
      }
      default:
        console.log('Invalid search command: ' + command);
    }
  }

  private printSearchResults(results: ReadonlySet<MediaItem>): void {
    console.log();

    if (results.size === 0) {
      console.log('No results found.');
      return;
    }

    console.log('Search results:\n');
    results.forEach((item) => {
      console.log('ID: ' + item.getId());
      console.log('TITLE: ' + item.getTitle());
      console.log('TYPE: ' + item.getType().toUpperCase());
      console.log();
    });
    console.log('Found ' + results.size + ' result(s).\n');
  }
}
