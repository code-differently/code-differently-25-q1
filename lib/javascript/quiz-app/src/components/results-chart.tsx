"use client"

import { Card } from "@/components/ui/card";
import { ChartContainer, ChartTooltip, ChartTooltipContent } from "@/components/ui/chart";


import { type ChartConfig } from "@/components/ui/chart";
import { Bar, BarChart, XAxis } from "recharts";


const chartConfig = {
  TypeScript: {
    label: "TypeScript",
    color: "#2563eb",
  },
  JavaScript: {
    label: "JavaScript",
    color: "#60a5fa",
  },
} satisfies ChartConfig

interface Vote {
  option: string
  count: number
}

interface ResultsChartProps {
  votes: Vote[]
}

export default function ResultsChart({ votes }: ResultsChartProps) {
  const total = votes.reduce((sum, vote) => sum + vote.count, 0)

  // Sort votes by count in descending order
  const sortedVotes = [...votes].sort((a, b) => b.count - a.count);

  return (
    <Card className="p-6 max-w-3xl mx-auto">
      <h2 className="text-xl font-semibold mb-6">Voting Results</h2>

      <ChartContainer className="gap-6" config={chartConfig}>
        <BarChart
          className="h-[300px]"
          data={sortedVotes}
        >
         <XAxis dataKey="option" />
         <ChartTooltip content={<ChartTooltipContent />} />
          {sortedVotes.map((vote) => (
            <Bar key={vote.option} dataKey="count" fill={`var(--color-${vote.option})`} radius={4}></Bar>
          ))}
        </BarChart>
      </ChartContainer>

      <div className="mt-6 text-center text-sm text-muted-foreground">Total votes: {total}</div>
    </Card>
  )
}

