import React from 'react';

type InputProps = {};

export class Input extends React.Component {
  inputRef: React.RefObject<HTMLInputElement>;

  constructor(props: InputProps) {
    super(props);
    this.inputRef = React.createRef();
  }

  focusInput() {
    this.inputRef.current?.focus();
    console.log('Input focused');
  }

  render() {
    return (
      <div>
        <input type="text" ref={this.inputRef} />
      </div>
    );
  }
}
