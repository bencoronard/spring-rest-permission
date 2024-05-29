import React from 'react';
import styles from '../styles/app.module.css';

type LifeCycleDemoProps = { user: string };
type LifeCycleDemoState = { message: string };

export class LifeCycleDemo extends React.Component<
  LifeCycleDemoProps,
  LifeCycleDemoState
> {
  constructor(props: LifeCycleDemoProps) {
    super(props);

    this.state = {
      message: 'Greetings',
    };

    // console.log('LifeCycle constructed');
  }

  static getDerivedStateFromProps(
    props: LifeCycleDemoProps,
    state: LifeCycleDemoState
  ) {
    // console.log('LifeCycle gotDerivedStateFromProps');
    return null;
  }

  shouldComponentUpdate(
    nextProps: Readonly<LifeCycleDemoProps>,
    nextState: Readonly<LifeCycleDemoState>,
    nextContext: any
  ): boolean {
    // console.log('LifeCycle shouldComponentUpdated');
    return true;
  }

  getSnapshotBeforeUpdate(
    prevProps: Readonly<LifeCycleDemoProps>,
    prevState: Readonly<LifeCycleDemoState>
  ) {
    // console.log('LifeCycle gotSnapshotBeforeUpdate');
    return null;
  }

  componentDidUpdate(
    prevProps: Readonly<LifeCycleDemoProps>,
    prevState: Readonly<LifeCycleDemoState>,
    snapshot?: any
  ): void {
    // console.log('LifeCycle componentHadUpdated');
  }

  componentDidMount(): void {
    // console.log('LifeCycle componentHadMounted');
  }

  componentWillUnmount(): void {
    // console.log('LifeCycle componentWouldUnmount');
  }

  render() {
    // console.log('LifeCycle rendered');
    return (
      <>
        <h1>
          {this.state.message},{' '}
          <span className={styles.success}>{this.props.user}</span> !
        </h1>
      </>
    );
  }
}
