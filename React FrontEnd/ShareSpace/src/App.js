import 'bootstrap/dist/css/bootstrap.min.css';
import { Routes, Route, Navigate } from 'react-router-dom'

import About from './HomeComponent/About';
//import Navbar from './HomeComponent/NavbarComponent';
import NavbarComponent from './HomeComponent/NavbarComponent';
import Login from './HomeComponent/Login';
import URegister from './UserComponent/URegister';
import HomePage from './UserComponent/HomePage';
import Grid from './UserComponent/Grid';
import JobList from './UserComponent/JobList';
import EHomePage from './ListerComponent/EHomePage';
import Profile from './ListerComponent/Profile';
import ERegister from './ListerComponent/ERegister';
import PostJob from './ListerComponent/PostJob'
import EJobList from './ListerComponent/EJobList';
import AppliersList from './ListerComponent/AppliersList';
import AppliedJobs from './UserComponent/AppliedJobs';


function App() {
  return (
    <div className="App">
      
      {/* <NavbarComponent/>
      <HomePage/> */}
      <Routes>
        <Route path="/" element={<NavbarComponent></NavbarComponent>}></Route>
        <Route path="/about" element={<About></About>}></Route>
        <Route path="/login" element={<Login></Login>}></Route>
        <Route path="/uregister" element={<URegister></URegister>}></Route>

        {/* <Route path="/" element={<Navbar></Navbar>}></Route>  */}

        <Route path="/homepage" element={<HomePage></HomePage>}></Route>
      <Route path="/grid" element={<Grid></Grid>}></Route>
        <Route path="/job" element={<JobList></JobList>}></Route> 
        <Route path="/applied" element={<AppliedJobs></AppliedJobs>}></Route>

        <Route path="/ehomepage" element={<EHomePage></EHomePage>}></Route>
        <Route path="/profile" element={<Profile></Profile>}></Route>
        <Route path="/eregister" element={<ERegister></ERegister>}></Route>
        <Route path="/postJob" element={<PostJob></PostJob>}></Route>
        <Route path="/ejob" element={<EJobList></EJobList>}></Route>

        <Route path="/ejob/appliers" element={<AppliersList />} /></Routes>
    </div>
  );
}

export default App;
