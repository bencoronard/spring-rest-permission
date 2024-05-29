import React from 'react';
import ReactDOM from 'react-dom';
import styles from '../styles/app.module.css';

type ClickCounterRenderProps = {
  count: number;
  incrementCount: () => void;
};

class ClickCounterRender extends React.Component<ClickCounterRenderProps> {
  render() {
    const { count, incrementCount } = this.props;
    const portalRoot = document.getElementById('portal-root');
    if (portalRoot) {
      return ReactDOM.createPortal(
        <button onClick={incrementCount} className={styles.black}>
          Clicked {count} times
        </button>,
        portalRoot
      );
    } else {
      return <h1>Cannot port</h1>;
    }
  }
}
export default ClickCounterRender;
