import readline from 'readline';

export class Scanner {
  private read: readline.Interface;
  constructor(read: readline.Interface) {
    this.read = read;
  }
  async prompt(message = ''): Promise<string> {
    return new Promise((resolve) => {
      this.read.question(`${message}> `, (input) => {
        resolve(input);
      });
    });
  }
}
