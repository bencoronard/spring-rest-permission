import React from 'react';
import { WithCounter } from './withCounter';
import styles from '../styles/appStyles.module.css';

type ClickCounterProps = {
  count: number;
  incrementCount: () => void;
  name: string;
};

class ClickCounter extends React.Component<ClickCounterProps> {
  render() {
    const { count, incrementCount, name } = this.props;
    return (
      <button onClick={incrementCount} className={styles.black}>
        {name} Clicked {count} times
      </button>
    );
  }
}

export default WithCounter(ClickCounter, 2);
