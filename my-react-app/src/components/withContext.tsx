import React from 'react';

const CustomContext = React.createContext('Default');

const CustomContextProvider = CustomContext.Provider;
const CustomContextConsumer = CustomContext.Consumer;

export { CustomContextProvider, CustomContextConsumer };
