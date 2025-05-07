import {DbImpl} from './db.js';
import {createServer} from './server.js';
import path from 'path';

const __dirname = path.dirname(new URL(import.meta.url).pathname);
const PROGRAMS_FILE = path.resolve(__dirname, './data/programs.json');

const db = new DbImpl(PROGRAMS_FILE);
createServer(db);
