import { useState } from 'react';
import { Heading } from './components/Heading';
import { Section } from './components/Section';
import { Counter } from './components/Counter';
import { List } from './components/List';
import { Form } from './components/Form';
import { LifeCycleDemo } from './components/LifeCycleDemo';
import { RefDemo } from './components/RefDemo';
import { InputParent } from './components/InputParent';
import { ForwardInputParent } from './components/ForwardInputParent';
import { PortalDemo } from './components/PortalDemo';
import { ErrorBound } from './components/ErrorBound';
import { ErrorProne } from './components/ErrorProne';
import { HoverCounter } from './components/HoverCounter';
import ClickCounter from './components/ClickCounter';
import CounterClass from './components/CounterClass';
import HoverCounterRender from './components/HoverCounterRender';
import ClickCounterRender from './components/ClickCounterRender';
import { CustomContextProvider } from './components/withContext';
import ContextConsumer from './components/ContextConsumer';
import HttpComponent from './components/HttpComponent';
import HttpForm from './components/HttpForm';

function App() {
  const [count, setCount] = useState(0);
  const myList = ['HTML', 'CSS', 'JavaScript', 'Java', 'NodeJS', 'Spring Boot'];
  const render = (item: string) => {
    return <span className="red">{item}</span>;
  };

  return (
    <>
      <Heading title="Hello world!" />
      <Section title="Lorem">
        Lorem ipsum dolor, sit amet consectetur adipisicing elit. Sint,
        obcaecati?
      </Section>
      <Form />
      <Counter setCount={setCount}>Count: {count}</Counter>
      <List items={myList} render={render}></List>
      <LifeCycleDemo user="Mr. Bond" />
      <RefDemo />
      <InputParent />
      <ForwardInputParent />
      <PortalDemo />
      <ErrorBound>
        <ErrorProne throwError={false} />
        <ErrorProne throwError={false} />
      </ErrorBound>
      <HoverCounter initial={0} />
      <ClickCounter name="Mr. Bourne" />
      <ClickCounter />
      <CounterClass
        inital={7}
        render={(count, incrementCount) => {
          return (
            <HoverCounterRender count={count} incrementCount={incrementCount} />
          );
        }}
      />
      <CounterClass
        inital={0}
        render={(count, incrementCount) => {
          return (
            <ClickCounterRender count={count} incrementCount={incrementCount} />
          );
        }}
      />
      <CustomContextProvider value="Non-default">
        <ContextConsumer />
      </CustomContextProvider>
      <HttpComponent />
      <HttpForm />
    </>
  );
}

export default App;
