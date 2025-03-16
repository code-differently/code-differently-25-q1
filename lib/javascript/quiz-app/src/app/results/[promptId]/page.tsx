import ClearVotesButton from "@/components/clear-votes-button"
import ResultsChart from "@/components/results-chart"
import { getAllVotes, getPrompt } from "@/lib/db"
import { currentUser } from "@clerk/nextjs/server"
import { redirect } from "next/navigation"

export default async function ResultsPage({
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
  let isAdmin = false;
  if (userId === 'anthony@morganlatimer.com') {
    isAdmin = true;
  }

  const promptId = +(await params).promptId;
  const prompt = await getPrompt(promptId);
  const topic = prompt?.Prompt;
  const votes = await getAllVotes(promptId);

  return (
    <div className="container mx-auto py-10">
      <div className="flex flex-col justify-between items-center mb-8">
        <h1 className="text-3xl font-bold mb-8 text-center">{topic}</h1>
        {isAdmin &&(
          <div className="flex items-center gap-4">
            <ClearVotesButton promptId={promptId} />
          </div>
        )}
      </div>
      <ResultsChart votes={votes} />
    </div>
  )
}

