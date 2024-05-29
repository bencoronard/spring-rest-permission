import { ReactNode } from 'react';
import styles from '../styles/app.module.css';

type SectionProps = { title?: string; children: ReactNode };

export const Section = ({ children, title = 'ABC' }: SectionProps) => {
  return (
    <>
      <section>
        <h2>{title}</h2>
        <div className={styles.error}>{children}</div>
      </section>
    </>
  );
};
