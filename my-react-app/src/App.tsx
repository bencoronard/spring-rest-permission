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
    </>
  );
}

export default App;
