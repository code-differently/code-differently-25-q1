# Database Seeding Guide

This guide explains how to use the seed script to populate your database with sample data for development and testing.

## What is Database Seeding?

Database seeding is the process of populating a database with initial data. It's particularly useful for:
- Development environments
- Testing
- Providing sample data for demonstrations
- Setting up initial state for applications

## Seed Data Contents

The seed script populates the database with:

- **Todos**: 12 sample todo items spread across 3 different users
- **Logs**: A single log entry recording the seed script execution

## How to Run the Seed Script

You can run the seed script using npm:

```bash
npm run db:seed
```

Or directly using ts-node:

```bash
npx ts-node prisma/seed.ts
```

## When to Run the Seed Script

You should run the seed script:

1. After setting up a fresh database
2. After clearing your development database
3. When you want to reset your database to a known state

## Modifying Seed Data

If you need to modify the seed data, edit the `/prisma/seed.ts` file. The script is structured as follows:

1. Define sample data in arrays
2. Use Prisma Client to insert the data into the database
3. Log the results

Feel free to add more sample data or modify existing data to suit your development needs.

## Important Notes

- The seed script will delete all existing todos before adding new ones
- The script adds a log entry to record its execution
- User IDs are strings and do not need to exist in an authentication system for development purposes
