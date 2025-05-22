import {Db} from './db.js';
import {Program} from '@code-differently/types';
import cors from 'cors';
import express, {Express, Request, Response} from 'express';

const UUID_PATTERN =
  /^[0-9a-f]{8}-[0-9a-f]{4}-[0-5][0-9a-f]{3}-[089ab][0-9a-f]{3}-[0-9a-f]{12}$/i;

export const createServer = (db: Db): Express => {
  const app: Express = express();

  app.use(express.static('public'));
  app.use(express.json());
  app.use(express.urlencoded({extended: true}));
  app.use(cors());

  app.get('/programs/:id', async (req: Request, res: Response<Program>) => {
    if (!isUuidValid(req.params.id)) {
      res.status(400).send();
      return;
    }
    const program = await db.getProgram(req.params.id);

    if (!program) {
      res.status(404).send();
      return;
    }

    res.status(200).send(program);
  });

  function isUuidValid(uuid: string): boolean {
    return !!uuid && !!uuid.match(UUID_PATTERN);
  }

  app.get('/programs', async (req: Request, res: Response<Program[]>) => {
    // Send the raw data back to the client as JSON.
    const programs = await db.getPrograms();
    res.status(200).send(programs);
  });

  app.post(
    '/programs',
    async (req: Request<Partial<Program>>, res: Response) => {
      const newProgram = req.body;
      try {
        db.addProgram(newProgram as Program);
      } catch (error: unknown) {
        res.status(500).send({error: 'Failed to add program.'});
        return;
      }
      console.log('Added new program');
      res.status(201).send();
    }
  );

  const port = process.env.port || 4000;
  app.listen(port, () => {
    console.log(`Server is running on http://localhost:${port}`);
  });

  return app;
};
