import React from 'react';
import ReactDOM from 'react-dom';
import styles from '../styles/app.module.css';

type HoverCounterRenderProps = {
  count: number;
  incrementCount: () => void;
};

class HoverCounterRender extends React.Component<HoverCounterRenderProps> {
  render() {
    const { count, incrementCount } = this.props;
    const portalRoot = document.getElementById('portal-root');
    if (portalRoot) {
      return ReactDOM.createPortal(
        <button onMouseOver={incrementCount} className={styles.black}>
          Hovered {count} times
        </button>,
        portalRoot
      );
    } else {
      return <h1>Could not port</h1>;
    }
  }
}
export default HoverCounterRender;
