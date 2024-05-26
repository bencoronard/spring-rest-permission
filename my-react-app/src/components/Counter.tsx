import { ReactNode } from 'react';

type CounterProps = {
  setCount: React.Dispatch<React.SetStateAction<number>>;
  children: ReactNode;
};

export const Counter = ({ setCount, children }: CounterProps) => {
  const incCount = () => {
    setCount((count) => count + 1);
  };

  const decCount = () => {
    setCount((count) => count - 1);
  };

  return (
    <>
      <h1>{children}</h1>
      <button className="red" onClick={incCount}>
        +
      </button>
      <button className="red" onClick={decCount}>
        -
      </button>
    </>
  );
};
