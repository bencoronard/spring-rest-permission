import { ReactElement } from 'react';
import styles from '../styles/app.module.css';

type HeadingProps = { title: string };

export const Heading = ({ title }: HeadingProps): ReactElement => {
  return <h1 className={styles.success}>{title}</h1>;
};
