import React from "react";

type ErrorBoundProps = {};
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

  static getDerivedStateFromError(error) {
    return { hasError: true };
  }

  render() {
    return <div>ErrorBound</div>;
  }
}

export default ErrorBound;
