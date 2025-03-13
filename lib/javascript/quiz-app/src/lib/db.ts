// In a real application, you would use a proper database
// This is a simple in-memory implementation for demonstration purposes

interface VoteRecord {
  topic: string
  option: string
  userId: string // Changed from userEmail to userId
  timestamp: Date
}

// In-memory storage
const votes: VoteRecord[] = []

export async function saveVote(vote: Omit<VoteRecord, "timestamp">) {
  const newVote = {
    ...vote,
    timestamp: new Date(),
  }

  votes.push(newVote)
  return newVote
}

export async function getUserVote(userId: string | null | undefined) {
  if (!userId) return null

  return votes.find((vote) => vote.userId === userId) || null
}

export async function getAllVotes() {
  // Count votes by option
  const voteCounts: Record<string, number> = {}

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

