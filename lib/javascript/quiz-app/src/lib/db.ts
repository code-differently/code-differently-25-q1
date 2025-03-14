// In a real application, you would use a proper database
// This is a simple in-memory implementation for demonstration purposes

import prisma from "./prisma"

interface VoteRecord {
  topic: string
  option: string
  userId: string // Changed from userEmail to userId
  createdAt: Date
}

export async function saveVote(vote: Omit<VoteRecord, "createdAt">) {
  const newVote = await prisma.votes.create({
    data: vote,
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

export async function getAllVotes() {
  // Count votes by option
  const voteCounts: Record<string, number> = {}

  const votes = await prisma.votes.findMany();

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

export async function clearVotes() {
  await prisma.votes.deleteMany({})
}

