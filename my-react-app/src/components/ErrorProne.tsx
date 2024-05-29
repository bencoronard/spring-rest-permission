import styles from '../styles/appStyles.module.css';

type ErrorProneProps = { throwError: boolean };

export function ErrorProne({ throwError }: ErrorProneProps) {
  if (throwError) {
    console.log('An error occurs.');
    throw new Error('errorerrorerror');
  }
  return <h1 className={styles.success}>Nothing interesting happened.</h1>;
}
