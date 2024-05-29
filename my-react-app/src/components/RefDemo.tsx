import React from 'react';
import styles from '../styles/app.module.css';

type RefDemoProps = {};

export class RefDemo extends React.Component {
  inputRef: React.RefObject<HTMLInputElement>;

  constructor(props: RefDemoProps) {
    super(props);
    this.inputRef = React.createRef();
  }

  componentDidMount(): void {
    this.inputRef.current?.focus();
  }

  clickHandler = () => {
    alert(this.inputRef.current?.value);
  };

  render() {
    return (
      <div>
        <label>What can I do for you today?</label>
        <input className={styles.black} type="text" ref={this.inputRef} />
        <button className={styles.black} onClick={this.clickHandler}>
          Sir!
        </button>
      </div>
    );
  }
}
