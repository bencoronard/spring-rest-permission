import React from 'react';

type WrapComponentProps = { name?: string };
type WrapComponentState = {
  count: number;
};

export const WithCounter = <P extends object>(
  WrappedComponent: React.ComponentType<any>,
  delta: number
) => {
  class WrapComponent extends React.Component<
    WrapComponentProps & P,
    WrapComponentState
  > {
    constructor(props: WrapComponentProps & P) {
      super(props);

      this.state = {
        count: 0,
      };
    }

    incrementCount = () => {
      this.setState((prevState) => {
        return { count: prevState.count + delta };
      });
    };

    render(): React.ReactNode {
      return (
        <WrappedComponent
          count={this.state.count}
          incrementCount={this.incrementCount}
          {...(this.props as P)}
        />
      );
    }
  }
  return WrapComponent;
};
