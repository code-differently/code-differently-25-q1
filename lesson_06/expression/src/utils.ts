import beautify from "js-beautify";
import { Interface } from "readline";

export const askQuestion = (
  rl: Interface,
  question: string,
): Promise<number> => {
  return new Promise((resolve) => {
    rl.question(question, (answer) => {
      resolve(parseInt(answer, 10));
    });
  });
};

export const getFunctionBody = (f: Function) => {
  const fString = f.toString().split("=>").pop()!;
  return beautify(fString);
};

export const printFormualaWithValues = (
  functionBody: string,
  a: number,
  b: number,
  c: number,
  d: number,
  e: number,
) => {
  const formula = new Array<string[]>(
    ["Math.pow", "pow"],
    ["a", String(a)],
    ["b", String(b)],
    ["c", String(c)],
    ["d", String(d)],
    ["e", String(e)],
    ["pow", "Math.pow"],
  ).reduce(
    (acc: string, param: string[]) => acc.replace(param[0]!, param[1]!),
    functionBody,
  );
  console.log(`\nNow computing the value of ${formula}`);
};
