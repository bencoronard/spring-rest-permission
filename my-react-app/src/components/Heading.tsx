import { ReactElement } from 'react';
import styles from '../styles/appStyles.module.css';

type HeadingProps = { title: string };

export const Heading = ({ title }: HeadingProps): ReactElement => {
  return <h1 className={styles.success}>{title}</h1>;
};
