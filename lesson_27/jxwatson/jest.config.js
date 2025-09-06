/** @type {import('ts-jest').JestConfigWithTsJest} **/
export default {
  testEnvironment: 'jest-fixed-jsdom',
  transform: {
    '^.+.tsx?$': ['ts-jest', {useESM: true}],
  },
  moduleNameMapper: {
    '\\.(css|less|sass|scss)$': 'identity-obj-proxy',
    '\\.(jpg|ico|jpeg|png|gif|eot|otf|webp|svg|ttf|woff|woff2|mp4|webm|wav|mp3|m4a|aac|oga)$':
      '<rootDir>/src/assets/__mocks__/fileMock.js',
  },
  extensionsToTreatAsEsm: ['.tsx', '.ts'],
};
