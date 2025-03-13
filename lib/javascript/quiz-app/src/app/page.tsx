import { getUserVote } from "@/lib/db";
import { currentUser } from "@clerk/nextjs/server";
import { redirect } from "next/navigation";

export default async function Home() {
  const user = await currentUser()

  //const userId = user.emailAddresses[0]?.emailAddress || user.id
  const userId = 'anthony@morganlatimer.com';

  // Check if user has already voted
  const hasVoted = await getUserVote(userId)

  // Redirect to results if already voted
  if (hasVoted) {
    return redirect("/results")
  }

  // Redirect to voting page if not voted yet
  return redirect("/vote")
}

