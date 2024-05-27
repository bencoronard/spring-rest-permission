import React from 'react';
import { ForwardInput } from './ForwardInput';
import styles from '../styles/appStyles.module.css';

type ForwardInputParentProps = {};

export class ForwardInputParent extends React.Component {
  inputRef: React.RefObject<HTMLInputElement>;

  constructor(props: ForwardInputParentProps) {
    super(props);

    this.inputRef = React.createRef();
  }

  clickHandler = () => {
    this.inputRef.current?.focus();
  };

  render() {
    return (
      <div>
        <ForwardInput ref={this.inputRef} />
        <button onClick={this.clickHandler} className={styles.black}>
          Focus Input
        </button>
      </div>
    );
  }
}

export default ForwardInputParent;
