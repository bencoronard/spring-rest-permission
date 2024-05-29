import React from 'react';
import { Input } from './Input';
import styles from '../styles/app.module.css';

type InputParentProps = {};

export class InputParent extends React.Component {
  focusRef: React.RefObject<Input>;

  constructor(props: InputParentProps) {
    super(props);
    this.focusRef = React.createRef();
  }

  clickHandler = () => {
    this.focusRef.current?.focusInput();
  };

  render() {
    return (
      <div>
        <Input ref={this.focusRef} />
        <button className={styles.black} onClick={this.clickHandler}>
          Focus
        </button>
      </div>
    );
  }
}
