import { createInterface } from "readline";
import { ExpressionCalculator } from "./expression_calculator.js";
import { FUNCTIONS } from "./functions.js";
import {
  askQuestion,
  getFunctionBody,
  printFormualaWithValues,
} from "./utils.js";

const rl = createInterface({
  input: process.stdin,
  output: process.stdout,
});

const main = async () => {
  const testFunction = FUNCTIONS[process.env.HW_VERSION || ""];
  if (testFunction === undefined) {
    console.log("HW_VERSION version not set in config. Exiting...");
    process.exit(1);
  }

  const functionBody = getFunctionBody(testFunction);
  console.log(`Function to implement: ${functionBody}`);

  const a = await askQuestion(rl, "\nEnter a value for variable 'a': ");
  const b = await askQuestion(rl, "Enter a value for variable 'b': ");
  const c = await askQuestion(rl, "Enter a value for variable 'c': ");
  const d = await askQuestion(rl, "Enter a value for variable 'd': ");
  const e = await askQuestion(rl, "Enter a value for variable 'e': ");
  rl.close();

  printFormualaWithValues(functionBody, a, b, c, d, e);

  const calculator = new ExpressionCalculator();
  const result = calculator.calculate(a, b, c, d, e);

  const isCorrect = result === testFunction(a, b, c, d, e);
  console.log(
    `\nThe result is ${isCorrect ? "correct" : "incorrect"}:`,
    result,
  );
};

main();
