import React, { ChangeEvent, Component } from 'react';
import styles from '../styles/app.module.css';

type FormProps = {};
type FormState = {
  username: string;
  comments: string;
  topic: string;
};

export class Form extends Component<FormProps, FormState> {
  constructor(props: FormProps) {
    super(props);

    this.state = {
      username: '',
      comments: '',
      topic: 'vue',
    };
  }

  handleUsernameChange = (event: ChangeEvent<HTMLInputElement>) => {
    this.setState({
      username: event.target.value,
    });
    // console.log(event.target.value);
  };

  handleCommentsChange = (event: ChangeEvent<HTMLTextAreaElement>) => {
    this.setState({
      comments: event.target.value,
    });
    // console.log(event.target.value);
  };

  handleTopicChange = (event: ChangeEvent<HTMLSelectElement>) => {
    this.setState({
      topic: event.target.value,
    });
    // console.log(event.target.value);
  };

  handleFormSubmit = (event: React.FormEvent<HTMLFormElement>) => {
    event.preventDefault();
    const formData: FormState = {
      username: this.state.username,
      topic: this.state.topic,
      comments: this.state.comments,
    };
    console.log(formData);
  };

  handleFormReset = (event: React.FormEvent<HTMLFormElement>) => {
    event.preventDefault();
    this.setState(
      {
        username: '',
        comments: '',
        topic: 'react',
      },
      () => {
        const formData: FormState = {
          username: this.state.username,
          topic: this.state.topic,
          comments: this.state.comments,
        };
        console.log(formData);
      }
    );
  };

  render() {
    return (
      <form onSubmit={this.handleFormSubmit} onReset={this.handleFormReset}>
        <div>
          <label>Username</label>
          <input
            type="text"
            value={this.state.username}
            onChange={this.handleUsernameChange}
            className={styles.black}
          />
        </div>

        <div>
          <label>Comments</label>
          <textarea
            value={this.state.comments}
            onChange={this.handleCommentsChange}
            className={styles.black}
          />
        </div>

        <div>
          <label>Topic</label>
          <select
            value={this.state.topic}
            onChange={this.handleTopicChange}
            className={styles.black}
          >
            <option value="react">React</option>
            <option value="angular">Angular</option>
            <option value="vue">Vue</option>
          </select>
        </div>

        <div className={styles.flexHorizontal}>
          <button type="submit" className={styles.black}>
            Submit
          </button>
          <button type="reset" className={styles.black}>
            Clear
          </button>
        </div>
      </form>
    );
  }
}
