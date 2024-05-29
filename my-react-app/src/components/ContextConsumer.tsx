import React from 'react';
import ReactDOM from 'react-dom';
import { CustomContextConsumer } from './withContext';

export class ContextConsumer extends React.Component {
  render() {
    const portalRoot = document.getElementById('portal-root');
    if (portalRoot) {
      return (
        <CustomContextConsumer>
          {(value) =>
            ReactDOM.createPortal(
              <div>Context consumed: {value}</div>,
              portalRoot
            )
          }
        </CustomContextConsumer>
      );
    } else {
      return null;
    }
  }
}

export default ContextConsumer;
