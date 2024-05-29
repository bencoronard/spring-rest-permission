import React from 'react';

type HoverCounterProps = { initial?: number };
type HoverCounterState = {
  count: number;
};

export class HoverCounter extends React.Component<
  HoverCounterProps,
  HoverCounterState
> {
  constructor(props: HoverCounterProps) {
    super(props);

    this.state = {
      count: props.initial ?? 0,
    };
  }

  incrementCount = () => {
    this.setState((prevState) => {
      return { count: prevState.count + 1 };
    });
  };

  render() {
    return (
      <h1 onMouseOver={this.incrementCount}>
        Hovered {this.state.count} times
      </h1>
    );
  }
}
