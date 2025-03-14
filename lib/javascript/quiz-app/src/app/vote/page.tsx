import VoteForm from "@/components/vote-form";
import { getUserVote } from "@/lib/db";
import { currentUser } from "@clerk/nextjs/server";
import { redirect } from "next/navigation";

export default async function VotePage() {
  const user = await currentUser()

  // Redirect to sign-in if not authenticated
  if (!user) {
    return redirect("/sign-in")
  }

  const userId = user.emailAddresses[0]?.emailAddress || user.id;

  // Check if user has already voted
  const hasVoted = await getUserVote(userId)

  // Redirect to results if already voted
  if (hasVoted) {
    return redirect("/results")
  }

  const topic = "What's your favorite programming language?"
  const options = ["JavaScript", "TypeScript", "Python", "Rust", "Go", "Other"]

  return (
    <div className="container mx-auto py-10">
      <h1 className="text-3xl font-bold mb-8 text-center">{topic}</h1>
      <VoteForm topic={topic} options={options} userId={userId} />
    </div>
  )
}

