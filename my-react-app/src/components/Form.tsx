import { ChangeEvent, Component } from 'react';

type FormProps = {};
type FormState = {
  username: string;
  comments: string;
};

export class Form extends Component<FormProps, FormState> {
  constructor(props: FormProps) {
    super(props);

    this.state = {
      username: '',
      comments: '',
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

  render() {
    return (
      <form>
        <div>
          <label>Username</label>
          <input
            type="text"
            value={this.state.username}
            onChange={this.handleUsernameChange}
          />
        </div>

        <div>
          <label>Comments</label>
          <textarea
            value={this.state.comments}
            onChange={this.handleCommentsChange}
          />
        </div>
      </form>
    );
  }
}
