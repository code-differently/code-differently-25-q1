import { PrismaClient } from '@prisma/client';

const prisma = new PrismaClient();

async function main() {
  console.log('Starting seed process...');

  // Clean up existing records to avoid duplicates
  await prisma.todos.deleteMany({});

  // Sample todos for a couple of different users
  const sampleTodos = [
    // User 1 todos
    {
      user_id: 'user1',
      text: 'Complete project documentation',
      completed: false,
    },
    {
      user_id: 'user1',
      text: 'Review pull requests',
      completed: true,
    },
    {
      user_id: 'user1',
      text: 'Plan sprint meeting',
      completed: false,
    },
    {
      user_id: 'user1',
      text: 'Fix high priority bugs',
      completed: false,
    },
    {
      user_id: 'user1',
      text: 'Update dependencies',
      completed: true,
    },

    // User 2 todos
    {
      user_id: 'user2',
      text: 'Learn about Docker',
      completed: false,
    },
    {
      user_id: 'user2',
      text: 'Prepare presentation',
      completed: true,
    },
    {
      user_id: 'user2',
      text: 'Research new technologies',
      completed: false,
    },
    {
      user_id: 'user2',
      text: 'Set up CI/CD pipeline',
      completed: false,
    },

    // User 3 todos
    {
      user_id: 'user3',
      text: 'Design new interface',
      completed: false,
    },
    {
      user_id: 'user3',
      text: 'Create wireframes',
      completed: true,
    },
    {
      user_id: 'user3',
      text: 'Implement dark mode',
      completed: true,
    },
  ];

  // Insert todos in batches
  const createdTodos = await Promise.all(
    sampleTodos.map(async (todo) => {
      return prisma.todos.create({
        data: todo,
      });
    }),
  );

  console.log(`Created ${createdTodos.length} todos`);

  // You can add sample logs as well if needed
  await prisma.logs.create({
    data: {
      level: 'info',
      message: 'Seed script executed',
      timestamp: new Date(),
      meta: { action: 'seed', numberOfTodos: createdTodos.length },
    },
  });

  console.log('Seed completed successfully!');
}

main()
  .catch((e) => {
    console.error('Error during seeding:', e);
    process.exit(1);
  })
  .finally(async () => {
    await prisma.$disconnect();
  });
