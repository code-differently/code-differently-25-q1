import ResultsChart from "@/components/results-chart"
import { getAllVotes } from "@/lib/db"
import { currentUser } from "@clerk/nextjs/server"
import { redirect } from "next/navigation"

export default async function ResultsPage() {
  const user = await currentUser()

  // Redirect to sign-in if not authenticated
  if (!user) {
    return redirect("/sign-in")
  }

  const topic = "What's your favorite programming language?"
  const votes = await getAllVotes()

  return (
    <div className="container mx-auto py-10">
      <h1 className="text-3xl font-bold mb-8 text-center">{topic}</h1>
      <ResultsChart votes={votes} />
    </div>
  )
}

