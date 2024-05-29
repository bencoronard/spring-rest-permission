import React from 'react';

type CounterClassProps = {
  render: (arg0: number, arg1: () => void) => React.ReactNode;
  inital?: number;
};
type CounterClassState = {
  count: number;
};

class CounterClass extends React.Component<
  CounterClassProps,
  CounterClassState
> {
  constructor(props: CounterClassProps) {
    super(props);

    this.state = {
      count: props.inital ?? 0,
    };
  }

  incrementCount = () => {
    this.setState((prevState) => {
      return { count: prevState.count + 1 };
    });
  };

  render() {
    return (
      <div>{this.props.render(this.state.count, this.incrementCount)}</div>
    );
  }
}

export default CounterClass;
