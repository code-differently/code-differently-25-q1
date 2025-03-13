import { getUserVote } from "@/lib/db";
import { currentUser } from "@clerk/nextjs/server";
import { redirect } from "next/navigation";

export default async function Home() {
  const user = await currentUser();

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

  // Redirect to voting page if not voted yet
  return redirect("/vote")
}

