import { ReactNode } from 'react';

type SectionProps = { title?: string; children: ReactNode };

export const Section = ({ children, title = 'ABC' }: SectionProps) => {
  return (
    <>
      <section>
        <h2>{title}</h2>
        <div>{children}</div>
      </section>
    </>
  );
};
