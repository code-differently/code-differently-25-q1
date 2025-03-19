import { flush, proxy } from "@alfonso-presa/soft-assert";
import { beforeEach, describe, expect, it } from "@jest/globals";
import {
  AnswerChoice,
  QuizConfig,
  QuizQuestion,
} from "codedifferently-instructional";
import path from "path";
import { fileURLToPath } from "url";
import { Lesson5 } from "./lesson5.js";

const __filename = fileURLToPath(import.meta.url); // get the resolved path to the file
const __dirname = path.dirname(__filename); // get the name of the directory
const softExpect = proxy(expect);

describe("Lesson5Test", () => {
  const quizConfig: QuizConfig = new QuizConfig(
    path.resolve(__dirname, "../quiz.yaml"),
  );
  let quizQuestions: QuizQuestion[];

  const EXPECTED_NUMBER_OF_QUESTIONS = 10;

  beforeEach(() => {
    getQuestions();
  });

  const getQuestions = () => {
    quizQuestions = Lesson5.makeQuizQuestions().sort(
      (a, b) => a.getQuestionNumber() - b.getQuestionNumber(),
    );
  };

  it("checkQuizQuestions_areAssembledCorrectly", () => {
    // Expect the right number of questions.
    expect(quizQuestions.length).toBe(EXPECTED_NUMBER_OF_QUESTIONS);

    // Expect questions to be numbered correctly.
    for (let i = 0; i < quizQuestions.length; i++) {
      expect(quizQuestions[i].getQuestionNumber()).toBe(i);
    }
  });

  it("checkQuizQuestions_promptsAreUnique", () => {
    const questionPrompts = new Set(
      quizQuestions.map((q) => q.getQuestionPrompt()),
    );
    expect(questionPrompts.size).toBe(EXPECTED_NUMBER_OF_QUESTIONS);
  });

  it("checkQuestions_answeredCorrectly", async () => {
    expect(quizConfig.size("default")).toBe(quizQuestions.length);

    for (const question of quizQuestions) {
      const actualAnswer = question.getAnswer();

      // Check that the question was answered.
      softExpect(actualAnswer).not.toBe(AnswerChoice.UNANSWERED);

      // Check that the answer is correct.
      softExpect(
        await quizConfig.checkAnswer(
          "default",
          question.getQuestionNumber(),
          actualAnswer,
        ),
      ).toBe(true);
    }

    flush();
  });
});
