import React from 'react';

type ForwardInputProps = {};

export const ForwardInput = React.forwardRef<
  HTMLInputElement,
  ForwardInputProps
>((props, ref) => {
  return (
    <div>
      <input type="text" ref={ref} />
    </div>
  );
});
