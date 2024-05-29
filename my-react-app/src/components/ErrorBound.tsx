import React from 'react';
import styles from '../styles/app.module.css';

type ErrorBoundProps = { children: React.ReactNode };
type ErrorBoundState = {
  hasError: boolean;
};

export class ErrorBound extends React.Component<
  ErrorBoundProps,
  ErrorBoundState
> {
  constructor(props: ErrorBoundProps) {
    super(props);

    this.state = {
      hasError: false,
    };
  }

  static getDerivedStateFromError(error: Error) {
    return { hasError: true };
  }

  render() {
    if (this.state.hasError) {
      return <h1 className={styles.error}>Something went wrong</h1>;
    }
    return <>{this.props.children}</>;
  }
}
