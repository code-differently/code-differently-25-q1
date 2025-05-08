import {Program} from '@code-differently/types';
import {randomUUID} from 'crypto';
import {Low} from 'lowdb';
import {JSONFilePreset} from 'lowdb/node';

export interface Db {
  getPrograms: () => Promise<Program[]>;
  getProgram: (id: string) => Promise<Program | null>;
  addProgram: (program: Program) => Promise<void>;
}

export interface DbData {
  programs: Program[];
}

export class DbImpl implements Db {
  private readonly db: Promise<Low<DbData>>;

  constructor(filePath: string) {
    this.db = this.loadDb(filePath);
  }

  async loadDb(filePath: string): Promise<Low<DbData>> {
    const defaultData: DbData = {programs: []};
    return await JSONFilePreset(filePath, defaultData);
  }

  async getPrograms(): Promise<Program[]> {
    const db = await this.db;
    return db.data.programs;
  }

  async getProgram(id: string): Promise<Program | null> {
    const db = await this.db;
    return db.data.programs.find(p => p.id === id) || null;
  }

  async addProgram(program: Program): Promise<void> {
    const db = await this.db;
    if (!program.id) {
      program.id = randomUUID();
    }
    db.data.programs.push(program);
    await db.write();
  }
}
