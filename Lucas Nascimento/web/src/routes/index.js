import React from 'react';
import { Switch, Route } from 'react-router-dom';

import HomePage from '../pages/HomePage';
import SignUpPage from '../pages/SignUpPage';
import SignInPage from '../pages/SignInPage';
import UserPage from '../pages/UserPage';
import ProfileEditPage from '../pages/ProfileEditPage';
import TaskListPage from '../pages/TaskListPage';
import TaskDoneListPage from '../pages/TaskDoneListPage';
import CreateTaskPage from '../pages/CreateTaskPage';

export default function Routes() {
  return (
    <Switch>
      <Route path="/" exact component={HomePage} />
      <Route path="/signup" exact component={SignUpPage} />
      <Route path="/signin" exact component={SignInPage} />

      <Route path="/app" exact component={UserPage} />
      <Route path="/app/profile" exact component={ProfileEditPage} />
      <Route path="/app/tasks" exact component={TaskListPage} />
      <Route path="/app/tasks/done" exact component={TaskDoneListPage} />
      <Route path="/app/tasks/new" exact component={CreateTaskPage} />
    </Switch>
  );
}
