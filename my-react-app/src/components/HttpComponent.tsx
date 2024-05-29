import React from 'react';
import axios from 'axios';
import ReactDOM from 'react-dom';
import styles from '../styles/app.module.css';

type HttpComponentProps = {};
type HttpComponentState = {
  posts: any[];
  errorMsg: string;
};

class HttpComponent extends React.Component<
  HttpComponentProps,
  HttpComponentState
> {
  constructor(props: HttpComponentProps) {
    super(props);

    this.state = {
      posts: [],
      errorMsg: '',
    };
  }

  componentDidMount(): void {
    axios
      .get('https://jsonplaceholder.typicode.com/posts')
      .then((response) => {
        this.setState({ posts: response.data.slice(0, 5) });
      })
      .catch((error) => {
        this.setState({ errorMsg: 'Error retrieving data' });
      });
  }

  render() {
    const { posts, errorMsg } = this.state;
    const portalRoot = document.getElementById('portal-root');
    if (portalRoot) {
      return ReactDOM.createPortal(
        <>
          <h1>List of Posts</h1>
          <ul>
            {posts.length
              ? posts.map((post) => (
                  <li key={post.id} className={styles.success}>
                    {JSON.stringify({ id: post.id, title: post.title })}
                  </li>
                ))
              : null}
            {errorMsg ? <h2 className={styles.error}>{errorMsg}</h2> : null}
          </ul>
        </>,
        portalRoot
      );
    } else {
      return <h1>Portal Closed</h1>;
    }
  }
}

export default HttpComponent;
