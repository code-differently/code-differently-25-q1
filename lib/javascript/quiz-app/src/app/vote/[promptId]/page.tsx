import VoteForm from "@/components/vote-form";
import { getPrompt, getUserVote } from "@/lib/db";
import { currentUser } from "@clerk/nextjs/server";
import { redirect } from "next/navigation";

export default async function VotePage({
  params,
}: {
  params: Promise<{ promptId: string }>
}) {
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

  const promptId = +(await params).promptId;
  const prompt = await getPrompt(promptId);
  const topic = '' + prompt?.Prompt;
  const options = (prompt?.Options as {options: string[]}).options;

  return (
    <div className="container mx-auto py-10">
      <h1 className="text-3xl font-bold mb-8 text-center">{topic}</h1>
      <VoteForm promptId={promptId} topic={topic} options={options} userId={userId} />
    </div>
  )
}

