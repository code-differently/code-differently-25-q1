"use client"

import type React from "react"

import { Button } from "@/components/ui/button"
import { Label } from "@/components/ui/label"
import { RadioGroup, RadioGroupItem } from "@/components/ui/radio-group"
import { submitVote } from "@/lib/actions"
import { useRouter } from "next/navigation"
import { useState } from "react"

interface VoteFormProps {
  topic: string
  options: string[]
  userId: string
}

export default function VoteForm({ topic, options, userId }: VoteFormProps) {
  const [selectedOption, setSelectedOption] = useState<string>("")
  const [isSubmitting, setIsSubmitting] = useState(false)
  const router = useRouter()

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault()
    if (!selectedOption) return

    setIsSubmitting(true)

    try {
      await submitVote({
        topic,
        option: selectedOption,
        userId,
      })

      router.push("/results")
    } catch (error) {
      console.error("Error submitting vote:", error)
    } finally {
      setIsSubmitting(false)
    }
  }

  return (
    <div>
      <form onSubmit={handleSubmit} className="max-w-md mx-auto">
        <RadioGroup value={selectedOption} onValueChange={setSelectedOption} className="space-y-4 mb-6">
          {options.map((option) => (
            <div
              key={option}
              className={`flex items-center space-x-2 rounded-lg border p-4 cursor-pointer transition-colors ${
                selectedOption === option ? "bg-primary/10 border-primary" : ""
              }`}
              onClick={() => setSelectedOption(option)}
            >
              <RadioGroupItem value={option} id={option} />
              <Label htmlFor={option} className="flex-1 cursor-pointer">
                {option}
              </Label>
            </div>
          ))}
        </RadioGroup>

        <Button type="submit" className="w-full" disabled={!selectedOption || isSubmitting}>
          {isSubmitting ? "Submitting..." : "Submit Vote"}
        </Button>
      </form>
    </div>
  )
}

