import React, { useState, useEffect } from 'react';
import CustomModal from './CustomModal';
import EmployerService from '../services/ListerService';
import AppliersList from './AppliersList';
import { Link, useNavigate } from 'react-router-dom';
import EHomePage from './EHomePage';
import './EHome.css';


function EJobList() {
    const navigate = useNavigate();

    const [jarr, setJarr] = useState([]);
    const [selectedJobAppliers, setSelectedJobAppliers] = useState([]);
    const [showApplierList, setShowApplierList] = useState(false);


    useEffect(() => {
        const storedUserName = localStorage.getItem('user');
        const userName = JSON.parse(storedUserName);

        EmployerService.getJobList(userName)
            .then((result) => {
                setJarr(result.data);
            })
            .catch(() => { });
    }, []);


    const applier = function (jobId) {
        EmployerService.getJobAppliers(jobId)
            .then((result) => {
                setSelectedJobAppliers(result.data);
                setShowApplierList(true);
            })
            .catch(() => { });
    };


    const deleteJob = function (jobId) {
        console.log(jobId);
        EmployerService.deleteJob(jobId)
            .then((result) => {
                console.log(result.data);
                setJarr(prevJarr => prevJarr.filter(job => job.id !== jobId)); // Remove the deleted job from the array
            });
    };
    

    return (
        <div>
            <div className="sticky-homepage">
                <EHomePage></EHomePage>
            </div>

            <div className="container py-3 sticky-div" >

                <div className="row" >

                    <div className="col-lg-6 sticky-description">

                        {jarr.map((job) => (

                            <div className="col-md-12" key={job.id}>
                                <div className="post">
                                    <div className="post__header d-flex justify-content-between align-items-center">
                                        <div className="post__info">
                                            <h5>
                                                <a href="description" className="post__link">
                                                    {job.jobTitle}
                                                </a>
                                            </h5>
                                            <h6>{job.jobDescription}</h6>
                                        </div>

                                        <div className="d-flex">
                                            <button
                                                type="button"
                                                onClick={() => applier(job.id)}
                                                className="btn btn-primary me-2"
                                            >
                                                Applier
                                            </button>


                                            <button
                                                type="button"
                                                onClick={() => deleteJob(job.id)}
                                                className="btn btn-danger"
                                            >
                                                Delete
                                            </button>
                                        </div>
                                    </div>
                                    <div className="post__body">
                                        <div className="px-4">
                                            <p className="post__details" style={{ color: "gray" }}>
                                                <span className="experience">Experience :_______yr</span>
                                                <span className="location px-2">Location :______</span>
                                                <span className="salary px-2">Salary : _______</span>
                                            </p>
                                            <p className="skill__details" style={{ color: "gray" }}>
                                                <h7>Skills : </h7>
                                            </p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        ))}

                    </div>

                    <div className="col-lg-6">
                        {/* Description */}
                        <div className="sticky-description">
                            <div className="col-md-12">
                                <div className="post">
                                    <div className="post__header d-flex justify-content-between align-items-center">
                                        <div className="post__info">
                                            fahjlfhrfio
                                            sjfklsjafkl
                                            sjk;sjadfkjsafk
                                            afkosadkf;gs;lv
                                            sddkfdskfjsjlsaldfhlhaslhflsah jfsdkfljsad kjsdkjfsk  ksjfkjskfjksjf jsdkjfksjfj;
                                        </div>
                                    </div>
                                    {showApplierList && (
                                        <div className="post__body">
                                            {selectedJobAppliers.map((applier) => (
                                                <li key={applier.freelancer.id}>{applier.freelancer.firstName}</li>
                                                // Render other applier details as needed
                                            ))}
                                        </div>
                                    )}
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
            </div>




        </div>
    );
}

export default EJobList;
