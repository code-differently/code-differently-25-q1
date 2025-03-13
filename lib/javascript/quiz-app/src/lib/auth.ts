import { currentUser } from "@clerk/nextjs/server"
import { redirect } from "next/navigation"

// Get the current authenticated user
export async function getAuthenticatedUser() {
  const user = await currentUser()

  if (!user) {
    redirect("/sign-in")
  }

  return user
}

// Get user's email (or a unique identifier)
export async function getUserIdentifier() {
  const user = await currentUser()
  return user?.emailAddresses[0]?.emailAddress || user?.id
}

// Check if user is authenticated
export async function isAuthenticated() {
  const user = await currentUser()
  return !!user
}

