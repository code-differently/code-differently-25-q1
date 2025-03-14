"use server"

import { clearVotes, saveVote } from "./db"

interface VoteData {
  topic: string
  option: string
  userId: string // Changed from userEmail to userId
}

export async function submitVote(data: VoteData) {
  try {
    // Validate data
    if (!data.topic || !data.option || !data.userId) {
      throw new Error("Missing required fields")
    }

    // Save vote
    await saveVote({
      topic: data.topic,
      option: data.option,
      userId: data.userId,
    })

    return { success: true }
  } catch (error) {
    console.error("Error submitting vote:", error)
    throw error
  }
}

export async function clearAllVotes() {
  try {
    await clearVotes()
    return { success: true }
  } catch (error) {
    console.error("Error clearing votes:", error)
    throw error
  }
}