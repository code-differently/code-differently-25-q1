// In a real application, you would use a proper database
// This is a simple in-memory implementation for demonstration purposes

import prisma from "./prisma"

interface VoteRecord {
  topic: string
  option: string
  userId: string
  promptId: number
  createdAt: Date
}

export async function saveVote(vote: Omit<VoteRecord, "createdAt">) {
  const newVote = await prisma.votes.create({
    data: {
      prompt_id: vote.promptId,
      topic: vote.topic,
      userId: vote.userId,
      option: vote.option,
    },
  })
  return {...newVote, createdAt: newVote.created_at}
}

export async function getUserVote(userId: string | null | undefined) {
  if (!userId) return null

  return await prisma.votes.findFirst({
    where: {
      userId: userId,
    },
  })
}

export async function getAllVotes(promptId: number) {
  // Count votes by option
  const voteCounts: Record<string, number> = {}

  const votes = await prisma.votes.findMany({
    where: {
      prompt_id: promptId,
    },
  });

  votes.forEach((vote) => {
    if (voteCounts[vote.option]) {
      voteCounts[vote.option]++
    } else {
      voteCounts[vote.option] = 1
    }
  })

  // Convert to array format for the chart
  return Object.entries(voteCounts).map(([option, count]) => ({
    option,
    count,
  }))
}

export async function clearVotes(promptId: number) {
  await prisma.votes.deleteMany({
    where: {
      prompt_id: promptId,
    },
  })
}

export async function getPrompt(id: number) {
  return await prisma.prompts.findFirst({
    where: {
      id: id,
    },
  });
}

