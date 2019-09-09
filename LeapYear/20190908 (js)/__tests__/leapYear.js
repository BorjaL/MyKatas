import isLeapYear from '../src/leapYear';

test('year 4 is leap because is divisible by 4', () => {
  expect(isLeapYear(4)).toBeTruthy();
});

test('year 1996 is leap because is divisible by 4', () => {
  expect(isLeapYear(1996)).toBeTruthy();
});

test('year 1900 is not leap because is divisible by 4 and 100 but not 400', () => {
  expect(isLeapYear(1900)).toBeFalsy();
});

test('year 2000 is a atypical leap year', () => {
  expect(isLeapYear(2000)).toBeTruthy();
});

test('year 5 is not leap because is not divisible by 4', () => {
  expect(isLeapYear(5)).toBeFalsy();
});

test('year 2001 is a typical common year bc is not divided by 4', () => {
  expect(isLeapYear(2001)).toBeFalsy();
});
